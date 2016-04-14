/*
 * SetForYouConstants.java
 *
 * Created on July 7, 2014
 *
 * Copyright 2014, Richemont SA;  All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Richemont SA, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Richemont SA.
 * 
 */
package mypackage.core;

/**
 * The Enum SetForYouConstants.
 * 
 * @author ragga7
 */
public enum ApplicationConstants {

	/** The nt unstructured. */
	NT_UNSTRUCTURED("nt:unstructured"),
	/** The backslash. */
	BACKSLASH("/"),
	/** The jcr createdby. */
	JCR_CREATEDBY("jcr:createdBy"),
	/** The jcr created. */
	JCR_CREATED("jcr:created"),
	/** The jcr description. */
	JCR_DESCRIPTION("jcr:description"),
	/** The sling res type. */
	SLING_RES_TYPE("sling:resourceType"),
	/** The admin. */
	ADMIN("admin"),
	/** The sfynodepath. */
	SFYNODEPATH("/content/dam/sfy"),
	/** The ref. */
	REF("ref"),
	/** The par. */
	PAR("par"),
	/** The price. */
	PRICE("price"),
	/** The carat. */
	CARAT("carat"),
	/** The color. */
	COLOR("color"),
	/** The clarity. */
	CLARITY("clarity"),
	/** The mincarat. */
	MINCARAT("mincarat"),
	/** The maxcarat. */
	MAXCARAT("maxcarat"),
	/** The application json. */
	APPLICATION_JSON("application/json"),
	/** The jcr mimetype. */
	JCR_MIMETYPE("jcr:mimeType"),
	/** The jcr data. */
	JCR_DATA("jcr:data"),
	/** The jcr lastmodified. */
	JCR_LASTMODIFIED("jcr:lastModified"),
	/** The nt resource. */
	NT_RESOURCE("nt:resource"),
	/** The jcr content. */
	JCR_CONTENT("jcr:content"),
	/** The mix referenceable. */
	MIX_REFERENCEABLE("mix:referenceable"),
	/** The nt file. */
	NT_FILE("nt:file"),
	/** The stonecharacteristic. */
	STONECHARACTERISTIC("StonesCharacteristic.json"),
	/** The defaultcountrycode. */
	DEFAULTCOUNTRYCODE("defaultCountryCode"),
	/** The get. */
	GET("GET"),
	/** The accept. */
	ACCEPT("Accept"),
	/** The application xml. */
	APPLICATION_XML("application/xml"),
	/** The designid. */
	DESIGNID("designID"),
	/** The maxvalue. */
	MAXVALUE("maxvalue"),
	/** The minvalue. */
	MINVALUE("minvalue"),
	/** The cr. */
	CR("CR"),
	/** The type of product. */
	TYPE_OF_PRODUCT("typeofProduct"),
	/** The imagesrc. */
	IMAGESRC("imgsrc"),
	/** The content. */
	CONTENT("content"),
	/** The server msg. */
	SERVER_MSG("serverMessage"),
	/** The success. */
	SUCCESS("success"),
	/** The material. */
	MATERIAL("material"),
	/** The server error msg. */
	SERVER_ERROR_MSG("An Error occured in Processing this request"),
	/** The UT f8. */
	UTF8("UTF-8"),
	/** The brand. */
	BRAND("CA"),
	/** The design param. */
	DESIGN_PARAM("design-selected"),
	/** The max carat param. */
	MAX_CARAT_PARAM("sfy_to_carat"),
	/** The min carat param. */
	MIN_CARAT_PARAM("sfy_from_carat"),
	/** The max price param. */
	MAX_PRICE_PARAM("sfy_to_price"),
	/** The min price param. */
	MIN_PRICE_PARAM("sfy_from_price"),
	/** The clarity param. */
	CLARITY_PARAM("clarity"),
	/** The color param. */
	COLOR_PARAM("colors"),
	/** The comma separator. */
	COMMA_SEPARATOR(","),
	/** The dot separator. */
	DOT_SEPARATOR("."),

	/** The platinum. */
	PLATINUM("platinum"),

	/** The whitegold. */
	WHITEGOLD("white gold"),

	/** The yellowgold. */
	YELLOWGOLD("yellow gold"),

	/** The pinkgold. */
	PINKGOLD("pink gold"),

	/** The currencysymbol. */
	CURRENCYSYMBOL("currencySymbol"),

	
	/** The collectionproductline. */
	PRODCOLL("collectionProductLine"),
	
	/** The SubCollection. */
	SUBCOLLECTION("subCollection"),
	
	/** The ShortDescription. */
	SHORTDESCRIPTION("shortDescription"),;
	

	/** The value. */
	private final String value;

	/**
	 * Custom Constructor.
	 * 
	 * @param value
	 *            the value
	 */
	private ApplicationConstants(final String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value.
	 */
	public String getValue() {
		return this.value;
	}

}
