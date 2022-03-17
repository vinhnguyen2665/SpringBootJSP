package com.vinhnq.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class CommonConst {
	public static class SYSTEM {
		public static String NAME = "Sensor System";
		public static String VERSION = "20210627";
		public static Long ID = 0L;
	}
	public static class CONFIG {
		public final static String JPADataSource = "JPADataSource";
		public final static String JPAEntityManagerFactory = "JPAEntityManagerFactory";
		public final static String JPATransactionManager = "JPATransactionManager";

		public final static String HibernateDataSource = "hibernateDataSource";
		public final static String HibernateSessionFactory = "hibernateSessionFactory";
		public final static String HibernateTransactionManager = "hibernateTransactionManager";
	}
	public static class PAGE_CODE {

		public static String attributeName = "selectedMenuCode";
		public static String dashboard = "1";
		public static String report = "2";
		public static String gateway = "3";
		public static String send_message = "4";
	}
	public static class COMMON_ROLE {
		public static String ADMIN = "ADMIN";
		public static String USER = "USER";
		public static String MANAGER = "MANAGER";
		public static String ROLE = "ROLE_";
	}

	public static class COMMON_SQL {
		public static String SEARCH_LIKE = "%";
		public static String SEARCH_NULL = "NULL";
	}

	public static class COMMON_RESPONSE {
		public static int OK = 200;
		public static int EXCEPTION = 500;
		public static int NON_AUTH = 203;
		public static int NON_ACTIVE = 204;
		public static int NOT_VALID = 422;
		public static int PERMISSION_DENIED = 403;

	}


	public static class DELETE_FLG {
		public static String DELETE = "1";
		public static String NON_DELETE = "0";
		public static Integer DELETE_INT = 1;
		public static Integer NON_DELETE_INT = 0;
	}

	public static class FALL_DETECTION {
		public static final int normal = 0;
		public static final int suddenMovement = 1;
		public static final int danger = 2;
	}

	public static class COMMON_MESSAGE {
		public static String LOGIN_SUCCESS = "LOGIN_SUCCESS";

		public static String UNKNOWN_ERROR = "UNKNOWN_ERROR";

		public static String ERROR_MESSAGE = "ERROR_MESSAGE";

		public static String USER_NOT_EXIST = "USER_1";

		public static String USER_NOT_LOGIN = "USER_2";

		public static String MODEL_NAN = "MODEL DON\'T RETURN";

		public static String PASSWORD_INCORRECT = "USER_3";

		public static String USER_NOT_EXIST_AND_PASSWORD_INCORRECT = "USER_4";

		public static String REQUIRE_LOGIN_FIRST = "USER_5";

		public static String UPDATE_SUCCESS = "USER_6";

		public static String USER_EXIST = "USER_7";

		public static String PERMISSION_DENIED = "USER_8";

		public static String OLD_PASSWORD_INCORRECT = "USER_9";

		public static String OLD_PASSWORD_IS_REQUIRED = "USER_10";

		public static String PASSWORD_IS_REQUIRED = "USER_11";

		public static String USERMAME_IS_REQUIRED = "USER_12";

		public static String DATA_NOT_VALID = "USER_13";

		public static String USER_DOESNT_HAVE_PERMISSION_TO_ACCESS_ANY_SHOP = "USER_14";

		public static String EMAIL_IS_REQUIRED = "USER_16";

		public static String FORGOT_SUCCESS = "USER_17";

		public static String OTP_INVALID = "USER_18";

		public static String USER_NEED_ACTIVE = "USER_19";

		public static String RENEW_OTP_DONE = "USER_20";

		public static String DATA_IS_DUPLICATE = "COMMON_01";

		public static String PRODUCT_DUPLICATE = "PRODUCT_01";

		public static String PRODUCT_NOT_EXIST = "PRODUCT_02";

		public static String SHOP_NOT_EXIST = "USER_15";

		public static String ORDER_NOT_EXIST = "ORDER_01";

		public static String ORDER_EXIST = "ORDER_02";

		public static String PRODUCT_NOT_ON_ORDER = "ORDER_03";

		public static String NUMBER_RETURN_NOT_VALID = "ORDER_04";

		public static String DELETE_SUCCESS = "COMMON_02";

		public static String DELETE_UNSUCCESS = "COMMON_03";

		public static String EXERCISE = "MESSAGE.exercise_warning";

		public static String MOVEMENT = "MESSAGE.movement_warning";

		public static String FALLING_WARNING = "MESSAGE.falling_warning";

	}

	public static class COMMON_STRING {
		public static String BLANK = "";
		public static String SPACE = " ";
		public static String SUCCESS = "SUCCESS";
		public static String NUMBER_0 = "0";
		public static String NUMBER_1 = "1";
		public static String IMAGE_HEADER_TYPE = "data:image";
	}

	public static class COMMON_FILE {
		/**
		 * Folder constant file resource Ex: image,....
		 */
		public static String HOME_RESOURCE = File.separator.concat("var").concat(File.separator).concat("www").concat(File.separator).concat("PipeCount");

		/**
		 * Folder constant file images resource
		 */
		public static String HOME_IMAGES = HOME_RESOURCE.concat(File.separator).concat("images").concat(File.separator);

		/**
		 * Folder constant profile images All file need in subfolder name is username
		 * and filename is time format shopid/username/yyyyMMdd_hhmmss
		 */
		public static String HOME_PROFILE_IMAGES = HOME_IMAGES.concat("profiles_images").concat(File.separator);

		/**
		 * Folder constant profile images All file need in subfolder name is
		 * shopid/username/product_id/yyyyMMdd_hhmmss
		 */
		public static String HOME_PRODUCTS_IMAGES = HOME_IMAGES.concat(File.separator).concat("product_images")
				.concat(File.separator);

	}

	public static class SIMPLE_DATE_FORMAT {
		/**
		 * yyyyyyyy-MM-dd HH:mm:ss
		 */
		public static final SimpleDateFormat formatterTimeStampyyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000");
		/**
		 * yyyy/MM/dd
		 */
		public static final SimpleDateFormat formatterYYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
		/**
		 * yyyyMMdd
		 */
		public static final SimpleDateFormat formatterYYYYMMDD2 = new SimpleDateFormat("yyyyMMdd");

		/**
		 * yyyy年MM月DD日
		 */
		public static final SimpleDateFormat formatteryyyyMMddJP = new SimpleDateFormat("yyyy年MM月dd日",
				java.util.Locale.JAPAN);
		/**
		 * yyyy/MM/dd HH:mm
		 */
		public static final SimpleDateFormat formatterYYYYMMDDHHMM = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		/**
		 * yyyyMMddHHmmssSSS
		 */
		public static final SimpleDateFormat formatterYYYYMMDDHHMMSSSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		/**
		 * yyyy/MM/dd HH:mm:ss
		 */
		public static final SimpleDateFormat formatterYYYYMMDDHHMMss = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		/**
		 * yyyyMMddHHmmss
		 */
		public static final SimpleDateFormat formatterYYYYMMDDHHMMss2 = new SimpleDateFormat("yyyyMMddHHmmss");
		/**
		 * yyyyMMddHHmmss
		 */
		public static final SimpleDateFormat formatterYYYYMMDDHHMM2 = new SimpleDateFormat("yyyyMMddHHmm");
		/**
		 * HHmm
		 */
		public static final SimpleDateFormat formatterHHmm = new SimpleDateFormat("HHmm");
		/**
		 * HH:mm
		 */
		public static final SimpleDateFormat formatterHHmm2 = new SimpleDateFormat("HH:mm");
		/**
		 * MM/dd
		 */
		public static final SimpleDateFormat formatterMMdd = new SimpleDateFormat("MM/dd");
		/**
		 * MM/dd (EEE)
		 */
		public static final SimpleDateFormat formatterMMddEEEJP = new SimpleDateFormat("MM/dd (EEE)",
				java.util.Locale.JAPAN);

		/**
		 * yyyy年MM月dd日 (EEE) 2021年4月9日 (金)
		 */
		public static final SimpleDateFormat formatteryyMMddEEEJP = new SimpleDateFormat("yyyy年MM月dd日 (EEE)",
				java.util.Locale.JAPAN);

		/**
		 * yy.MM.dd
		 */
		public static final SimpleDateFormat formatteryyMMdd = new SimpleDateFormat("yy.MM.dd");

		/**
		 * yyyy-MM
		 */
		public static final SimpleDateFormat formatterYYYY_MM = new SimpleDateFormat("yyyy-MM");
	}

	public static class REGEX{
		public static final Pattern EMAIL =
				Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]{1,}\\.[a-zA-Z0-9-]{2,}(?:\\.[a-zA-Z0-9-]{2,})*$", Pattern.CASE_INSENSITIVE);
	}
	public static class MAIL{
		public static String USERNAME = "";
		public static String PASSWORD = "";
	}

}
