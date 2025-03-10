package com.structuralPattern.decoratorPattern.message;

public class Main {

  public static void main(String[] args) {
    Message message = new TextMessage("Hello World!");

    Message encryptedMessage = new EncryptionDecorator(message);
    Message compressedMessage = new CompressionDecorator(encryptedMessage);

    compressedMessage.send();
  }
}
