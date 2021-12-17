import grpc from 'k6/net/grpc';
import { check, sleep } from 'k6';

const client = new grpc.Client();

export default () => {
  client.connect('localhost:50051', {
    plaintext: true,
    reflect: true
  });

  const data = { greeting: 'Bert'};
  const response = client.invoke('HelloService/SayHello', data);

  check(response, {
    'status is OK': (r) => r && r.status === grpc.StatusOK,
  });

  console.log(JSON.stringify(response.message));

  client.close();
  sleep(1);
};