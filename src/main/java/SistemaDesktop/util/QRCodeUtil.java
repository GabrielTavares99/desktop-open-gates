package SistemaDesktop.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtil {
    public static void createQRCode(String qrCodeData, String filePath,
                                    int qrCodeheight, int qrCodewidth) {

        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        qrCodeData = new String(qrCodeData.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        BitMatrix matrix;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            matrix = multiFormatWriter.encode(qrCodeData,
                    BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                    .lastIndexOf('.') + 1), new File(filePath));
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }


    }

}
