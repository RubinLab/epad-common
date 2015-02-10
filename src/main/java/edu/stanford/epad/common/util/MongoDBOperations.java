package edu.stanford.epad.common.util;

import java.util.Arrays;

import org.json.XML;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

public class MongoDBOperations {
	private static final EPADLogger log = EPADLogger.getInstance();

	private static DB mongoDB;
	public static DB getMongoDB()
	{
		if (mongoDB == null)
		{
			try {
				String mongoHost = EPADConfig.mongoHostname;
				if (mongoHost == null) return null;
				MongoClient mongoClient = null;
				if (EPADConfig.mongoUser == null)
				{
					mongoClient = new MongoClient(mongoHost);
				}
				else
				{
					MongoCredential credential = MongoCredential.createCredential(EPADConfig.mongoUser, EPADConfig.mongoDB, EPADConfig.mongoPassword.toCharArray());
					mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
				}
				mongoDB = mongoClient.getDB(EPADConfig.mongoDB);
			} catch (Exception e) {
				log.warning("Error connecting to MongoDB", e);
			}
		}
		return mongoDB;
	}
	
	public static void saveJsonToMongo(String jsonString, String collection) throws Exception
	{
		try {
			DB db = MongoDBOperations.getMongoDB();
	        if (db == null)
	        {
	        	log.warning("No connection to Mongo DB");
	        	return;
	        }
			DBCollection coll = db.getCollection(collection);
			DBObject dbObject = (DBObject) JSON.parse(jsonString);
			//TODO: Check if document exists and replace instead of insert
	        coll.insert(dbObject);
		} catch (Exception e) {
			log.warning("Error saving to mongodb:", e);
			throw e;
		}
	}
	
	public static int getNumberOfDocuments(String jsonQuery, String collection) throws Exception
	{
		try {
			int count = 0;
			DB db = MongoDBOperations.getMongoDB();
	        if (db == null)
	        {
	        	log.warning("No connection to Mongo DB");
	        	return count;
	        }
			DBCollection coll = db.getCollection(collection);
			if (jsonQuery != null && jsonQuery.trim().length() > 0)	{
				DBObject dbQuery = (DBObject) JSON.parse(jsonQuery);
				return coll.find(dbQuery).count();
			} else {
				return coll.find().count();				
			}

		} catch (Exception e) {
			log.warning("Error querying mongodb:", e);
			throw e;
		}
	}
	
	public static void saveAnnotationToMongo(String annotationID, String aimXML, String collection) throws Exception
	{
		try {
			DB db = MongoDBOperations.getMongoDB();
	        if (db == null)
	        {
	        	log.warning("No connection to Mongo DB");
	        	return;
	        }
			String jsonString =  XML.toJSONObject(aimXML).toString(0);;
	        if (jsonString == null)
	        	throw new Exception("Error converting to json");
	        DBCollection dbColl = db.getCollection(collection);
	        BasicDBObject dbObj = new BasicDBObject("ImageAnnotationCollection.imageAnnotations.ImageAnnotation.uniqueIdentifier.root", 1);
	        dbColl.createIndex(dbObj, "uid_idx"); // Does not create index, if it already exists
	        BasicDBObject query = new BasicDBObject();
	        query.put("ImageAnnotationCollection.imageAnnotations.ImageAnnotation.uniqueIdentifier.root", annotationID);
			DBObject dbObject = (DBObject) JSON.parse(jsonString);
	        DBCursor cursor = dbColl.find(query);
            if (cursor.count() > 0) {
                //Logger.info("Updating existing annotation");
            	dbColl.update(query, dbObject, true, false);
            } else {
                //Logger.info("Creating new annotation in mongoDB");
            	dbColl.insert(dbObject);
            }
		} catch (Exception e) {
			log.warning("Error saving AIM to mongodb:", e);
			throw e;
		}
	}

}
