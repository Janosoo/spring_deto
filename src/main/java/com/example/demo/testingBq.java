package com.example.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class testingBq {

	@Transactional
	public static void simpleQuery() throws Exception {
	    try {
	    	String query = "SELECT unique_key, date, description FROM `bigquery-public-data.chicago_crime.crime` where date  > '2018-01-01' LIMIT 1000";
	    	
	    	
	    	  GoogleCredentials credentials1;
	    	  File credentialsPath = new File("/home2/prueba-a0c76ee03570.json");  // TODO: update to your key path.
	    	  try (FileInputStream serviceAccountStream = new FileInputStream(credentialsPath)) {
	    	    credentials1 = ServiceAccountCredentials.fromStream(serviceAccountStream);
	    	  }

	      // Initialize client that will be used to send requests. This client only needs to be created
	      // once, and can be reused for multiple requests.
	      BigQuery bigquery = BigQueryOptions.newBuilder().setCredentials(credentials1).build().getService();

	      // Create the query job.
	      QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();

	      // Execute the query.
	      TableResult result = bigquery.query(queryConfig);

	      // Print the results.
	      result.iterateAll().forEach(rows -> 
	      {
	       System.out.println(rows.get("unique_key").getValue());
	       System.out.println(rows.get("date").getValue());
	       System.out.println(rows.get("description").getValue());
	       });

	    		  
	      System.out.println("Query ran successfully");
	    } catch (BigQueryException | InterruptedException e) {
	      System.out.println("Query did not run \n" + e.toString());
	    }
	  }
	}
