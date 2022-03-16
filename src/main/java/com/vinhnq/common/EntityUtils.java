package com.vinhnq.common;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.log4j.Logger;

import com.vinhnq.beans.UserBeans;
import com.vinhnq.entity.User;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class EntityUtils {
    public static final Logger logger = Logger.getLogger(EntityUtils.class);
    private static final boolean usingLogger = false, usingStackTrackGeneration = true;

    public static void main(String[] args) {
       // genGetterSetter(GpsTracker.class, GpsTrackerBeans.class);
        //genGetterSetter("scrapShijiBodyBean", "scrapShijiBody", ScrapShijiBodyBean.class, ScrapShijiBody.class);
    }


    /**
     * @param source Class
     * @param dest   Class
     * @return String
     * @author vinhnq
     * @implNote Example genGetterSetter(SokokanIdoShijiBody.class, SokokanIdoShijiBodyBean.class);
     */
    public static String genGetterSetter(Class<?> source, Class<?> dest) {
        String classNameSrc = source.getSimpleName();
        String classNameDes = dest.getSimpleName();


        String varSrcName = WordUtils.uncapitalize(classNameSrc);
        String varDesName = WordUtils.uncapitalize(classNameDes);

        //Single
        String methodName = "convert" + classNameSrc + "To" + classNameDes;
        String param = "(" + classNameSrc + " " + varSrcName + ")";
        String declareMethod = "public static " + classNameDes + " " + methodName + param + " {";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(declareMethod);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\tif(null == " + varSrcName + ") {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn null;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t" + classNameDes + " " + varDesName + " = new " + classNameDes + "();");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(genGetterSetter(varSrcName, varDesName, source, dest, false));
        stringBuilder.append("\t" + "return " + varDesName + ";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("}");
        stringBuilder.append(System.lineSeparator());

        //List
        String methodNameList = "List<" + classNameDes + "> convert" + classNameSrc + "To" + classNameDes;
        String paramList = "(List<" + classNameSrc + "> " + varSrcName + "Lst)";
        String declareMethodList = "public static " + methodNameList + paramList + " {";
        stringBuilder.append(declareMethodList);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\tif(null == " + varSrcName + "Lst) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\treturn null;");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\tList<" + classNameDes + "> " + varDesName + "Tmp" + " = new ArrayList<" + classNameDes + ">();");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\tfor (" + classNameSrc + " " + varSrcName + " : " + varSrcName + "Lst) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t" + varDesName + "Tmp" + ".add(" + methodName + "(" + varSrcName + "));");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\treturn " + varDesName + "Tmp" + ";");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("}");
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * @param varSourceName ten bien nguon dang khai bao
     * @param varDesName    ten bien dich dang khai bao
     * @param source        class cua nguon Class.class
     * @param dest          class cua dich Class.class
     * @return Console java code get value nguon set cho value dich
     * @implNote Example EntityUtils.genGetterSetter("tanaOroshiBody", "tanaOroshiBodyBean", TanaOroshiBody.class, TanaOroshiBodyBean.class);
     */

    public static StringBuilder genGetterSetter(String varSourceName, String varDesName, Class<?> source, Class<?> dest) {
        return genGetterSetter(varSourceName, varDesName, source, dest, true);
    }


    /**
     * @param varSourceName ten bien nguon dang khai bao
     * @param varDesName    ten bien dich dang khai bao
     * @param source        class cua nguon Class.class
     * @param dest          class cua dich Class.class
     * @param sysout        in output len console
     * @return Console java code get value nguon set cho value dich
     * @Example EntityUtils.genGetterSetter(" tanaOroshiBody ", " tanaOroshiBodyBean ", TanaOroshiBody.class, TanaOroshiBodyBean.class);
     */
    public static StringBuilder genGetterSetter(String varSourceName, String varDesName, Class<?> source, Class<?> dest, boolean sysout) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> mapSourceMethod = new HashMap<String, String>();
        Map<String, String> mapGetSourceMethod = new HashMap<String, String>();
        Map<String, String> mapSetSourceMethod = new HashMap<String, String>();
        //Map<String, String> mapDestMethod = new HashMap<String, String>();
        Map<String, String> mapGetDestMethod = new HashMap<String, String>();
        Map<String, String> mapSetDestMethod = new HashMap<String, String>();

        Map<String, String> mapSourceSetConvert = new HashMap<String, String>();
        //Map<String, String> mapSourceGetConvert = new HashMap<String, String>();
        //Map<String, String> mapDestConvert = new HashMap<String, String>();

        //Get Ten method set get
        for (Method method : source.getMethods()) {
            if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
                mapGetSourceMethod.put(method.getName(), method.getName());
            }

            if (method.getName().startsWith("set") && !method.getName().equals("getClass")) {
                mapSetSourceMethod.put(method.getName(), method.getName());
            }

            mapSourceMethod.put(method.getName(), method.getName());
        }
        for (Method method : dest.getMethods()) {
            if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
                mapGetDestMethod.put(method.getName(), method.getName());
            }

            if (method.getName().startsWith("set")) {
                mapSetDestMethod.put(method.getName(), method.getName());
            }
        }

        //Ca source va dest cung co set va get thi moi convert
        for (Map.Entry<String, String> entry : mapSourceMethod.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            boolean conditionSet = mapSetSourceMethod.containsKey(key) && mapSetDestMethod.containsKey(key);
            //boolean conditionGet = mapGetSourceMethod.containsKey(key) && mapGetDestMethod.containsKey(key);
            if (conditionSet) {
                mapSourceSetConvert.put(key, value);
            }
            /*
             * if(conditionGet) { mapSourceGetConvert.put(key, value); };
             * System.out.println((key + ":" + value));
             */
        }

        for (Map.Entry<String, String> entry : mapSourceSetConvert.entrySet()) {
            /* String key = entry.getKey(); */
            String value = entry.getValue();
            stringBuilder.append(genSetterSetter(varSourceName, varDesName, value));
        }
        if (sysout) {
            System.out.println(stringBuilder.toString());
        }
        return stringBuilder;
    }

    private static String genSetterSetter(String varSourceName, String varDesName, String methodName) {
        StringBuilder stringBuilder = new StringBuilder();
        String methodNameTmp = methodName.replace("set", "");
        stringBuilder.append("\tif (null != " + varSourceName + ".get" + methodNameTmp + "()) {");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t\t" + varDesName + ".set" + methodNameTmp + "(" + varSourceName + ".get" + methodNameTmp + "());");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("\t}");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    private static void error(String message) {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        String _message = "";
        for (int i = ste.length - 1; i > 2; i--) {
            _message += ste[i].getClassName() + "." + ste[i].getMethodName() + "(" + ste[i].getLineNumber() + ") => ";
        }
        _message += ste[2].getClassName() + "." + ste[2].getMethodName() + "(" + ste[2].getLineNumber() + "): " + message;
        if (usingLogger) {
            logger.error(usingStackTrackGeneration ? _message : message);
        } else {
            System.out.println(_message);
        }
    }

    public interface IEntityConverter {

        String getFieldGetter(Field field);

        String getFieldSetter(Field field);

        String getFieldForGetter(Field field);

        String getFieldForSetter(Field field);

        Object getFieldValueForSetter(Field field, Object value);
    }

    public static List<Field> getAllFields(Class<?> type) {
        return getAllFields(new ArrayList<Field>(), type);
    }

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));
        if (type.getSuperclass() != null) {
            fields = getAllFields(fields, type.getSuperclass());
        }
        return fields;
    }

    public static List<Method> getAllMethods(Class<?> type) {
        return getAllMethods(new ArrayList<Method>(), type);
    }

    public static List<Method> getAllMethods(List<Method> methods, Class<?> type) {
        methods.addAll(Arrays.asList(type.getDeclaredMethods()));
        if (type.getSuperclass() != null) {
            methods = getAllMethods(methods, type.getSuperclass());
        }
        return methods;
    }

    public static List<String> getPropertiesName(Object object) {
        List<String> propertiesName = new ArrayList<String>();
        try {
            List<Field> fields = getAllFields(object.getClass());
            for (Field m : fields) {
                propertiesName.add(m.getName());
            }
            return propertiesName;
        } catch (Exception ex) {
            error(ex.getMessage());
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isList(Class clazz) {
        if (clazz.equals(List.class) || clazz.equals(AbstractCollection.class)) {
            return true;
        }
        if (clazz.getSuperclass() != null) {
            return isList(clazz.getSuperclass());
        }
        return false;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isPrimitiveType(Class clazz) {
//        return clazz.toString().equals("byte")
//                || clazz.toString().equals("short")
//                || clazz.toString().equals("int")
//                || clazz.toString().equals("long")
//                || clazz.toString().equals("float")
//                || clazz.toString().equals("double")
//                || clazz.toString().equals("boolean")
//                || clazz.toString().equals("char");
        return clazz.isPrimitive();
    }

    @SuppressWarnings("rawtypes")
    public static boolean isPrimitiveClass(Class clazz) {
        return ((clazz.equals(Integer.class))
                || (clazz.equals(Long.class))
                || (clazz.equals(Short.class))
                || (clazz.equals(Byte.class))
                || (clazz.equals(Double.class))
                || (clazz.equals(Float.class))
                || (clazz.equals(Date.class))
                || (clazz.equals(String.class)));
    }

    public static void setValueProperty(Object object, Field field,
                                        Object value, IEntityConverter entityConverter) {
        try {
            String convertedSetter = null, convertedForSetter = null;
            Object convertedValueForSetter = null;
            if (entityConverter != null) {
                convertedSetter = entityConverter.getFieldSetter(field);
                convertedForSetter = entityConverter
                        .getFieldForSetter(field);
                convertedValueForSetter = entityConverter.getFieldValueForSetter(field, value);
            }
            List<Method> methods = getAllMethods(object.getClass());
            if (convertedForSetter != null || convertedSetter != null) {
                for (Method m : methods) {
                    if (convertedForSetter != null
                            && m.getName().equalsIgnoreCase(
                            "set" + convertedForSetter)
                            && m.getParameterTypes().length == 1) {
                        if (value == null
                                && isPrimitiveType(m.getParameterTypes()[0])) {
                        } else {
                            m.invoke(object, convertedValueForSetter);
                        }
                        return;
                    } else if (convertedSetter != null
                            && m.getName().equalsIgnoreCase(convertedSetter)
                            && m.getParameterTypes().length == 1) {
                        if (value == null
                                && isPrimitiveType(m.getParameterTypes()[0])) {
                        } else {
                            m.invoke(object, convertedValueForSetter);
                        }
                        return;
                    }
                }
            }
            for (Method m : methods) {
                if (m.getName().equalsIgnoreCase("set" + field.getName())
                        && m.getParameterTypes().length == 1) {
                    if (value == null
                            && isPrimitiveType(m.getParameterTypes()[0])) {
                    } else {
                        if (entityConverter == null) {
                            m.invoke(object, value);
                        } else {
                            m.invoke(object, convertedValueForSetter);
                        }
                    }
                    return;
                }
            }
        } catch (Exception ex) {
            error(ex.getMessage());
        }
    }

    @SuppressWarnings("rawtypes")
    public static Object getValueProperty(Object object, Field field,
                                          IEntityConverter entityConverter) {
        String propertyName = field.getName();
        try {
            if (propertyName.contains(".")) {
                String[] parts = propertyName.split("\\.");
                for (int i = 0; i < parts.length; i++) {
                    if (object == null) {
                        break;
                    }
                    Class clazz = object.getClass();
                    String convertedGetter = null, convertedForGetter = null;
                    if (entityConverter != null) {
                        convertedGetter = entityConverter
                                .getFieldGetter(field);
                        convertedForGetter = entityConverter
                                .getFieldForGetter(field);
                    }
                    List<Method> mts = getAllMethods(clazz);
                    boolean foundForConverter = false;
                    if (convertedForGetter != null || convertedGetter != null) {
                        for (Method mt : mts) {
                            if (convertedForGetter != null
                                    && (mt.getName().equalsIgnoreCase(
                                    "get" + convertedForGetter) || mt
                                    .getName().equalsIgnoreCase(
                                            "is" + convertedForGetter))) {
                                foundForConverter = true;
                                object = mt.invoke(object);
                                break;
                            } else if (convertedGetter != null
                                    && mt.getName().equalsIgnoreCase(
                                    convertedGetter)) {
                                foundForConverter = true;
                                object = mt.invoke(object);
                                break;
                            }
                        }
                    }
                    if (!foundForConverter) {
                        for (Method mt : mts) {
                            if (mt.getName().equalsIgnoreCase("get" + parts[i])
                                    || mt.getName().equalsIgnoreCase("is" + parts[i])) {
                                object = mt.invoke(object);
                                break;
                            }
                        }
                    }
                    if ((i < parts.length - 1) && (object != null)) {
                        clazz = object.getClass();
                    }
                }
                return object;
            }
            String convertedGetter = null, convertedForGetter = null;
            if (entityConverter != null) {
                convertedGetter = entityConverter.getFieldGetter(field);
                convertedForGetter = entityConverter
                        .getFieldForGetter(field);
            }
            List<Method> mts = getAllMethods(object.getClass());
            if (convertedForGetter != null || convertedGetter != null) {
                for (Method method : mts) {
                    if (convertedForGetter != null
                            && (method.getName().equalsIgnoreCase(
                            "get" + convertedForGetter) || method.getName()
                            .equalsIgnoreCase("is" + convertedForGetter))) {
                        return method.invoke(object);
                    } else if (convertedGetter != null
                            && method.getName().equalsIgnoreCase(convertedGetter)) {
                        return method.invoke(object);
                    }
                }
            }
            for (Method method : mts) {
                if (method.getName().equalsIgnoreCase("get" + propertyName)
                        || method.getName().equalsIgnoreCase("is" + propertyName)) {
                    return method.invoke(object);
                }
            }
        } catch (Exception ex) {
            error(ex.getMessage());
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public static Object initializeObjectBySource(Object source) {
        Object object = null;
        try {
            String className = source.getClass().getCanonicalName();
            String componentClassName = className;
            if (source.getClass().getComponentType() != null) {
                componentClassName = source.getClass().getComponentType().toString();
                componentClassName = componentClassName.substring(6);
                if (componentClassName.startsWith("[L")) {
                    componentClassName = componentClassName.substring(2, componentClassName.length() - 1);
                }
            }
            if (className.endsWith("[][]")) {
                Object[][] sources = (Object[][]) source;
                Class<?> c = Class.forName(componentClassName);
                Object o = Array.newInstance(c, sources.length, sources[0].length);
                for (int i = 0; i < sources.length; i++) {
                    Object row = Array.get(o, i);
                    for (int j = 0; j < sources[i].length; j++) {
                        Class cItem = Class.forName(componentClassName);
                        Object val = cItem.newInstance();
                        Array.set(row, j, val);
                    }
                }
                object = o;
            } else if (className.endsWith("[]")) {
                Object[] sources = (Object[]) source;
                Class<?> c = Class.forName(componentClassName);
                Object o = Array.newInstance(c, sources.length);
                for (int i = 0; i < sources.length; i++) {
                    Class cItem = Class.forName(componentClassName);
                    Object val = cItem.newInstance();
                    Array.set(o, i, val);
                }
                object = o;
            } else {
                Class c = Class.forName(source.getClass().getName());
                object = c.newInstance();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            error(ex.getMessage());
        }
        return object;
    }

    public static Object cloneEntity(Object target, Object source) {
        return cloneEntity(target, source, new String[]{}, null);
    }

    public static Object cloneEntity(Object target, Object source,
                                     IEntityConverter entityConverter) {
        return cloneEntity(target, source, new String[]{}, entityConverter);
    }

    public static Object cloneEntity(Object target, Object source,
                                     String[] exclusions) {
        return cloneEntity(target, source, exclusions, null);
    }

    @SuppressWarnings("unchecked")
    public static Object cloneEntity(Object target, Object source,
                                     String[] exclusions, IEntityConverter entityConverter) {
        if (source == null) {
            return null;
        }
        if (target == null) {
            target = initializeObjectBySource(source);
            if (target == null) {
                return null;
            }
        }
        if (target.getClass().isArray()) {
            Object[] targets = (Object[]) target;
            Object[] sources = (Object[]) source;
            for (int i = 0; i < sources.length; i++) {
                if (sources[i] == null) {
                    continue;
                }
                if (!isPrimitiveType(sources[i].getClass())) {
                    if (targets[i] == null) {
                        targets[i] = initializeObjectBySource(sources[i]);
                    }
                    if (targets[i] != null) {
                        if (isPrimitiveClass(sources[i].getClass())) {
                            if (entityConverter == null) {
                                targets[i] = sources[i];
                            } else {
                                targets[i] = entityConverter.getFieldValueForSetter(null, sources[i]);
                            }
                        } else {
                            targets[i] = cloneEntity(targets[i], sources[i], exclusions, entityConverter);
                        }
                    }
                } else {
                    if (entityConverter == null) {
                        targets[i] = sources[i];
                    } else {
                        targets[i] = entityConverter.getFieldValueForSetter(null, sources[i]);
                    }
                }
            }
            target = targets;
        } else if (isList(target.getClass())) {
            List<Object> targets = (List<Object>) target;
            List<Object> sources = (List<Object>) source;
            for (Object sourcez : sources) {
                if (!isPrimitiveType(sourcez.getClass()) && !isPrimitiveClass(sourcez.getClass())) {
                    Object targetz = initializeObjectBySource(sourcez);
                    if (targetz != null) {
                        cloneEntity(targetz, sourcez, exclusions, entityConverter);
                        targets.add(targetz);
                    }
                } else {
                    if (entityConverter == null) {
                        targets.add(sourcez);
                    } else {
                        targets.add(entityConverter.getFieldValueForSetter(null, sourcez));
                    }
                }
            }
        } else {
            List<Field> fields = getAllFields(target.getClass());
            for (Field field : fields) {
                boolean excluded = false;
                for (String exclusion : exclusions) {
                    if (exclusion.equals(field.getName())) {
                        excluded = true;
                        break;
                    }
                }
                if (excluded) {
                    continue;
                }
                if (isPrimitiveType(field.getType()) || isPrimitiveClass(field.getType())) {
                    setValueProperty(target, field,
                            getValueProperty(source, field, entityConverter),
                            entityConverter);
                } else {
                    Object targetField = getValueProperty(target, field, entityConverter);
                    Object sourceField = getValueProperty(source, field, entityConverter);
                    if (sourceField != null) {
                        if (targetField == null) {
                            targetField = initializeObjectBySource(sourceField);
                            if (targetField == null) {
                                continue;
                            }
                        }
                        targetField = cloneEntity(targetField, sourceField, exclusions, entityConverter);
                        setValueProperty(target, field, targetField, entityConverter);
                    }
                }
            }
        }
        return target;
    }


    public static UserBeans convertUserToUserBeans(User user) {
        if (null == user) {
            return null;
        }
        UserBeans userBeans = new UserBeans();
        userBeans.setId(user.getId());
        if (null != user.getPassword()) {
            userBeans.setPassword(user.getPassword());
        }
        if (null != user.getUpdateDate()) {
            userBeans.setUpdateDate(user.getUpdateDate());
        }
        if (null != user.getUpdateById()) {
            userBeans.setUpdateById(user.getUpdateById());
        }
        if (null != user.getSex()) {
            userBeans.setSex(user.getSex());
        }
        if (null != user.getDepartment()) {
            userBeans.setDepartment(user.getDepartment());
        }
        userBeans.setCreateById(user.getCreateById());
        if (null != user.getMidName()) {
            userBeans.setMidName(user.getMidName());
        }
        if (null != user.getDeleteFlg()) {
            userBeans.setDeleteFlg(user.getDeleteFlg());
        }
        if (null != user.getLastName()) {
            userBeans.setLastName(user.getLastName());
        }
        if (null != user.getAuthority()) {
            userBeans.setAuthority(user.getAuthority());
        }
        if (null != user.getEmail()) {
            userBeans.setEmail(user.getEmail());
        }
        if (null != user.getDateOfBirth()) {
            userBeans.setDateOfBirth(user.getDateOfBirth());
        }
        if (null != user.getFirstName()) {
            userBeans.setFirstName(user.getFirstName());
        }
        if (null != user.getCreateDate()) {
            userBeans.setCreateDate(user.getCreateDate());
        }
        return userBeans;
    }

    public static List<UserBeans> convertUserToUserBeans(List<User> userLst) {
        if (null == userLst) {
            return null;
        }
        List<UserBeans> userBeansTmp = new ArrayList<UserBeans>();
        for (User user : userLst) {
            userBeansTmp.add(convertUserToUserBeans(user));
        }
        return userBeansTmp;
    }

}

