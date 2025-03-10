package com.structuralPattern.proxyPattern.networkProxy;

import java.util.HashMap;

public class ProxyNetworkRequest implements Request {

  private NetworkRequest networkRequest;
  private static HashMap<String, String> cache = new HashMap<>();

  ProxyNetworkRequest() {
    this.networkRequest = new NetworkRequest();
  }

  @Override
  public String request(String endpoint) {

    if (cache.containsKey(endpoint)) {

      System.out.println("request from cache " + endpoint);
      return cache.get(endpoint);

    } else {
      cache.put(endpoint, endpoint);
      System.out.println("request from proxy " + endpoint);
      return networkRequest.request(endpoint);
    }
  }

}
