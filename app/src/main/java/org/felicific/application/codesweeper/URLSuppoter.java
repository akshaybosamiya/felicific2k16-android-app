package org.felicific.application.codesweeper;


import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class URLSuppoter {
	
	public  String GET(String url) {
		InputStream inputStream = null;
		String result = "";
		try {

			// create HttpClient
			HttpClient httpclient = new DefaultHttpClient();

			// make GET request to the given URL
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

			// receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();

			// convert inputstream to string
			if (inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";

		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}

		return result;
	}
	
	public   String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

		
	}
	
	/*public  String POST(String url, PersonDetail person) {
		InputStream inputStream = null;
		String result = "";
		try {

			// 1. create HttpClient
			HttpClient httpclient = new DefaultHttpClient();
			// 2. make POST request to the given URL
			HttpPost httpPost = new HttpPost(url);
			// String json = "";

			// 3. build jsonObject
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("SystemUserID", person.getSystemUserID());
			jsonObject.accumulate("CustomerID", person.getCustomerID());
			jsonObject.accumulate("FirstName", person.getFirstName());

			jsonObject.accumulate("LastName", person.getLastName());
			jsonObject.accumulate("MiddleInitial", person.getMiddleInitial());
			jsonObject.accumulate("PhoneNo", person.getPhoneNo());

			jsonObject.accumulate("MobileNo", person.getMobileNo());
			jsonObject.accumulate("FaxNo", person.getFaxNo());
			jsonObject.accumulate("EmailID", person.getEmailID());

			jsonObject.accumulate("Address1", person.getAddress1());
			jsonObject.accumulate("Address2", person.getAddress2());
			jsonObject.accumulate("StreetName", person.getStreetName());

			jsonObject.accumulate("City", person.getCity());
			jsonObject.accumulate("State", person.getState());
			jsonObject.accumulate("Country", person.getCountry());

			jsonObject.accumulate("Zipcode", person.getZipcode());
			jsonObject.accumulate("BirthDate", person.getBirthDate());
			jsonObject.accumulate("Gender", person.getGender());

			jsonObject.accumulate("CompanyName", person.getCompanyName());
			jsonObject.accumulate("Designation", person.getDesignation());
			jsonObject.accumulate("CustomerType", person.getCustomerType());

			jsonObject.accumulate("PrefferedTimeToContact",
					person.getPrefferedTimeToContact());
			jsonObject.accumulate("HeardAboutUs", person.getHeardAboutUs());
			jsonObject.accumulate("DailyAlert", person.getDailyAlert());

			jsonObject.accumulate("NewsLetter", person.getNewsLetter());
			jsonObject.accumulate("Username", person.getUsername());
			jsonObject.accumulate("Password", person.getPassword());

			jsonObject.accumulate("ExtraInfo", person.getExtraInfo());
			jsonObject.accumulate("Comments", person.getComments());
			jsonObject.accumulate("IPAddress", person.getIPAddress());

			// 4. convert JSONObject to JSON to String
			// json = jsonObject.toString();

			// ** Alternative way to convert Person object to JSON string usin
			// Jackson Lib
			// ObjectMapper mapper = new ObjectMapper();
			// json = mapper.writeValueAsString(person);

			// 5. set json to StringEntity
			StringEntity se = new StringEntity(jsonObject.toString());

			// 6. set httpPost Entity
			httpPost.setEntity(se);

			// // 7. Set some headers to inform server about the type of the
			// content
			// httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader(HTTP.CONTENT_TYPE,
					"application/json; charset=utf-8");
			// se.setContentType("application/json;charset=UTF-8");
			// se.setContentEncoding(new
			// BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
			// 8. Execute POST request to the given URL
			HttpResponse httpResponse = httpclient.execute(httpPost);

			// 9. receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();

			// 10. convert inputstream to string
			if (inputStream != null)
			{
				
				 
				result = convertInputStreamToString(inputStream);
				Sharedpref.setcustomerid(result);
			Sharedpref.setfirstname(person.getFirstName());
			Sharedpref.setlastname(person.getLastName());
			Sharedpref.setstatecode(person.getState());
			Sharedpref.setmail(person.getEmailID());
			Sharedpref.setpass(person.getPassword());
			
			}
			else
				result = "Did not work!";

		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}

		// 11. return result
		Log.d("result",""+result);
		return result;
	}
*/
}
