package edu.stanford.epad.common.util;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
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
				MongoClient mongoClient = new MongoClient(mongoHost);
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

}
