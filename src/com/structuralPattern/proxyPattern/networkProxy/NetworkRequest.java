package com.structuralPattern.proxyPattern.networkProxy;

public class NetworkRequest implements Request {

  @Override
  public String request(String endpoint) {
    System.out.println("send request from NetworkRequest to " + endpoint);

    return endpoint + " -> response";
  }

}
