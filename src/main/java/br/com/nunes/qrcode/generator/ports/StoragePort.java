package br.com.nunes.qrcode.generator.ports;

public interface StoragePort {

    String uploadFile (byte[] fileData, String fileName, String contentType);
}
