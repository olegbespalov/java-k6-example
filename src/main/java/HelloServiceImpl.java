import io.grpc.stub.StreamObserver;

public class HelloServiceImpl
        extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(
            Hello.HelloRequest request,
            StreamObserver<Hello.HelloResponse> responseObserver) {
        System.out.println(
                "Handling hello endpoint: " + request.toString());


        String text = "Hello " + request.getGreeting();
        Hello.HelloResponse response =
                Hello.HelloResponse.newBuilder()
                        .setReply(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}