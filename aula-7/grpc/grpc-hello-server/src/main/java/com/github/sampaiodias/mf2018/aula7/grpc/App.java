package com.github.sampaiodias.mf2018.aula7.grpc;

import io.grpc.*;

public class App
{
    public static void main( String[] args ) throws Exception
    {
      // Create a new server to listen on port 8081
      Server server = ServerBuilder.forPort(8081)
        .addService(new GreetingServiceImpl())
        .build();

      // Start the server
      server.start();

      // Server threads are running in the background.
      System.out.println("Server started");
      // Don't exit the main thread. Wait until server is terminated.
      server.awaitTermination();
    }
}