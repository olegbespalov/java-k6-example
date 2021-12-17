import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

public class HelloWorldServer {
   private static final int PORT = 50051;
   private Server server;

   public void start() throws IOException {
       server = ServerBuilder.forPort(PORT)
               .addService(new HelloServiceImpl())
               .addService(ProtoReflectionService.newInstance())
               .build()
               .start();
   }

   public void blockUntilShutdown() throws InterruptedException {
       if (server == null) {
           return;
       }

       server.awaitTermination();
   }

   public static void main(String[] args) 
           throws InterruptedException, IOException {
       HelloWorldServer server = new HelloWorldServer();

        System.out.println("Starting service...");

       server.start();
       server.blockUntilShutdown();
   }
}