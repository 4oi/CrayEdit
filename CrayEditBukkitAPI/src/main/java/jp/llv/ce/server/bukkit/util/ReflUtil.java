/*
 * Copyright (c) 2015 Toyblocks
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jp.llv.ce.server.bukkit.util;

import java.lang.reflect.Field;
import org.apache.commons.lang.reflect.*;

/**
 *
 * @author Toyblocks
 */
public class ReflUtil {

    public static Object invoke(Object callee, String mname, Object... arguments) {
        if (callee instanceof Class) {
            return invokeStatic((Class) callee, mname, arguments);
        }
        //ReflectiveObject.unwrap(arguments);
        try {
            return MethodUtils.invokeMethod(callee, mname, arguments);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Object invokeStatic(Class<?> callee, String mname, Object... arguments) {
        //ReflectiveObject.unwrap(arguments);
        try {
            return MethodUtils.invokeStaticMethod(callee, mname, arguments);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Object getField(Object callee, String fname) {
        if (callee instanceof Class) {
            return getFieldStatic((Class) callee, fname);
        }
        try {
            return getReflectionField(callee.getClass(), fname).get(callee);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Object getFieldStatic(Class<?> callee, String fname) {
        try {
            return getReflectionField(callee, fname).get(null);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void setField(Object callee, String fname, Object value) {
        if (callee instanceof Class) {
            setFieldStatic((Class) callee, fname, value);
        }
        try {
            getReflectionField(callee.getClass(), fname).set(callee, value);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void setFieldStatic(Class<?> callee, String fname, Object value) {
        try {
            getReflectionField(callee, fname).set(null, value);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Field getReflectionField(Class<?> target, String fname) throws NoSuchFieldException, SecurityException {
        for (Class ctc = target; ctc != null; ctc = ctc.getSuperclass()) {
            try {
                Field field = ctc.getDeclaredField(fname);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            } catch (NoSuchFieldException ex) {
                //continue;
            }
        }
        throw new NoSuchFieldException();
    }

    public static ReflectiveObject wrap(Object toWrap) {
        return toWrap != null ? new ReflectiveObject(toWrap) : null;
    }

    public static Object newInstance(String className, Object... arguments) {
        //ReflectiveObject.unwrap(arguments);
        try {
            Class<?> clazz = Class.forName(className);
            return ConstructorUtils.invokeConstructor(clazz, arguments);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ReflectiveObject wrappedInstance(String className, Object... arguments) {
        return new ReflectiveObject(newInstance(className, arguments));
    }

    public static class ReflectiveObject {

        private final Object content;

        private ReflectiveObject(Object content) {
            this.content = content;
        }

        public ReflectiveObject m(String method, Object... arguments) {
            Object obj = invoke(this.content, method, arguments);
            return obj != null ? new ReflectiveObject(obj) : null;
        }

        public ReflectiveObject f(String field) {
            Object obj = getField(this.content, field);
            return obj != null ? new ReflectiveObject(obj) : null;
        }

        public ReflectiveObject s(String field, Object value) {
            setField(this.content, field, value);
            return this;
        }

        public Object unwrap() {
            return content;
        }

        private static void unwrap(Object... toUnwrap) {
            for (int i = 0; i < toUnwrap.length; i++) {
                if (toUnwrap[i] instanceof ReflectiveObject) {
                    ReflectiveObject obj = (ReflectiveObject) toUnwrap[i];
                    toUnwrap[i] = obj.unwrap();
                }
            }
        }

    }

}
