package io.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 오픈채팅방 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
          "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(record));
        String[] output = new 오픈채팅방().solution(record);
        System.out.println(Arrays.toString(output));
    }

    public String[] solution(String[] record) {
        Map<String, UserRecord> userRecords = new HashMap<>();
        int order = 0;
        for (String input : record) {
            String[] split = input.split(" ");
            order++;
            String eventType = split[0];
            String userId = split[1];
            String userName = split.length > 2 ? split[2] : null;

            UserRecord userRecord = userRecords.get(userId);
            if(userRecord == null){
                userRecord = new UserRecord(userId, userName);
                userRecords.put(userId, userRecord);
            }

            if ("Enter".equals(eventType)) {
                userRecord.changeName(userName);
                userRecord.addEvent(eventType, order);
            } else if ("Leave".equals(eventType)) {
                userRecord.addEvent(eventType, order);
            } else {
                userRecord.changeName(userName);
            }
        }

        List<String> messages = userRecords.values().stream()
          .flatMap(userRecord -> userRecord.getSortableMessages().stream())
          .sorted()
          .map(sortableMessage -> sortableMessage.message)
          .collect(Collectors.toList());

        String[] result = new String[messages.size()];
        return messages.toArray(result);
    }

    class UserRecord {
        String userId;
        String name;
        List<Event> events = new ArrayList<>();

        public UserRecord(String userId, String name){
            this.userId = userId;
            this.name = name;
        }

        public void changeName(String name){
            this.name = name;
        }

        public void addEvent(String type, int order){
            this.events.add(new Event(type, order));
        }

        public List<SortableMessage> getSortableMessages(){
            return events.stream()
              .map( event -> {
                  if("Enter".equals(event.type)){
                      return new SortableMessage(name + "님이 들어왔습니다.", event.order);
                  }else if("Leave".equals(event.type)){
                      return new SortableMessage(name + "님이 나갔습니다.", event.order);
                  }
                  throw new IllegalArgumentException("");
              })
              .collect(Collectors.toList());
        }
    }

    class Event {

        String type;
        int order;

        public Event(String type, int order) {
            this.type = type;
            this.order = order;
        }
    }
    
    class SortableMessage implements Comparable<SortableMessage> {
        String message;
        int order;
         public SortableMessage(String message, int order){
             this.message = message;
             this.order = order;
         }

        @Override
        public int compareTo(SortableMessage o) {
            return this.order - o.order;
        }
    }
}
