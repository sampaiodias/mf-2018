package com.github.sampaiodias.mf2018.aula7.grpc;

import io.grpc.*;

public class App
{
    public static void main( String[] args ) throws Exception
    {
      // Channel is the abstraction to connect to a service endpoint
      // Let's use plaintext communication because we don't have certs
      final ManagedChannel channel = 
              ManagedChannelBuilder.forTarget("localhost:8081")
        .usePlaintext(true)
        .build();

      // It is up to the client to determine whether to block the call
      // Here we create a blocking stub, but an async stub,
      // or an async stub with Future are always possible.
      SendIdentificadorServiceGrpc.SendIdentificadorServiceBlockingStub stub = 
              SendIdentificadorServiceGrpc.newBlockingStub(channel);
      IdentificadorOuterClass.Identificador request = buildIdentificador();

      // Finally, make the call using the stub
      IdentificadorOuterClass.Identificador response = 
        stub.sendIdentificador(request);

      System.out.println(response);

      // A Channel should be shutdown before stopping the process.
      channel.shutdownNow();
    }
    
    public static IdentificadorOuterClass.Identificador buildIdentificador() {
      IdentificadorOuterClass.Identificador.Certidao c = 
          IdentificadorOuterClass.Identificador.Certidao.newBuilder()
              .setCartorio("A")
              .build();

      IdentificadorOuterClass.Identificador.TituloEleitoral t = 
          IdentificadorOuterClass.Identificador.TituloEleitoral.newBuilder()
              .setSessao(1)
              .setZona(2)
              .build();

      IdentificadorOuterClass.Identificador id = IdentificadorOuterClass.
          Identificador.newBuilder()
              .setCodigoArea(12345)
              .setCodigoTipo("TIPO")
              .setData("20180101")
              .setDesignacao("DESIGNACAO")
              .setEmissor("EMISSOR")
              .setId(1234)
              .setIdIndividuo(123)
              .setCertidao(c)
              .setTituloEleitoral(t)
              .build();

      return id;
    }
}