package oversecured.plugin.assassin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public  class Utils {
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[65536];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            outputStream.write(bArr, 0, read);
        }
    }
}
