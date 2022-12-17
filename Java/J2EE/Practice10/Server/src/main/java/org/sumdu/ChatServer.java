package org.sumdu;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer implements Runnable {
    
    private final Map<Integer, Socket> mapClient = new HashMap<>();

    @Override
    public void run() {

        ServerSocket server;
        try {
            server = new ServerSocket(8887);
            System.out.println("Сервер запустився. Очікуємо підключення клієнтів.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int numberClient = 1;
        Socket client;

        while (true) {
            try {
                client = server.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Thread clientThread = new Thread(new ClientThread(client, this, numberClient));
            clientThread.setDaemon(true);
            clientThread.start();
            mapClient.put(numberClient, client);
            numberClient++;
        }
    }

    public void sendMessageForAllClient(int numberClient, String clientMessage) {

        for (int i = 1; i <= mapClient.size(); i++) {
            if (numberClient != i) {
                System.out.println(
                        "Відправка повідомлення до Клієнту №" +
                        numberClient +
                        "\n");
                BufferedWriter out;

                try {
                    out = new BufferedWriter(new OutputStreamWriter(mapClient.get(i).getOutputStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    out.write(
                            "Клієнт №" +
                                numberClient +
                                ": " + clientMessage + ""
                    );
                    out.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
