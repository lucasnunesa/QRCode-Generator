package br.com.nunes.qrcode.generator.controller;

import br.com.nunes.qrcode.generator.dto.QrCodeGenerateRequest;
import br.com.nunes.qrcode.generator.dto.QrCodeGenerateResponse;
import br.com.nunes.qrcode.generator.service.QrCodeGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest qrCodeGenerateRequest) throws IOException, WriterException {
        try {
            QrCodeGenerateResponse response = this.qrCodeGeneratorService.generateAndUploadQrCode(qrCodeGenerateRequest.text());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
