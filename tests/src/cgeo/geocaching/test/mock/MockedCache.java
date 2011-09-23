package cgeo.geocaching.test.mock;

import cgeo.geocaching.ICache;
import cgeo.geocaching.cgBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class MockedCache implements ICache {

    /*
     * The data for the caches can be generated by entering the url
     * http://www.geocaching.com/seek/cache_details.aspx?log=y&wp=GCxxxx&numlogs=35&decrypt=y
     * into a browser and saving the file
     */
    public String getData() {
        try {
            final InputStream is = this.getClass().getResourceAsStream("/cgeo/geocaching/test/mock/"+getGeocode()+".html");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            final StringBuffer buffer = new StringBuffer();
            String line = null;

            while ((line = br.readLine()) != null) {
                buffer.append(line).append("\n");
            }

            br.close();
            return cgBase.replaceWhitespace(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


}
