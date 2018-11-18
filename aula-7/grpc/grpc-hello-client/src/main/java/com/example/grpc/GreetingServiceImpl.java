package com.example.grpc;

import com.github.sampaiodias.mf2018.aula7.grpc.IdentificadorOuterClass;
import com.github.sampaiodias.mf2018.aula7.grpc.SendIdentificadorServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends SendIdentificadorServiceGrpc.SendIdentificadorServiceImplBase {
    @Override
    public void sendIdentificador(IdentificadorOuterClass.Identificador request,
          StreamObserver<IdentificadorOuterClass.Identificador> responseObserver) {
    // HelloRequest has toString auto-generated.
      System.out.println(request);

      // You must use a builder to construct a new Protobuffer object
      IdentificadorOuterClass.Identificador response = buildIdentificador();

      // Use responseObserver to send a single response back
      responseObserver.onNext(response);

      // When you are done, you must call onCompleted.
      responseObserver.onCompleted();
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