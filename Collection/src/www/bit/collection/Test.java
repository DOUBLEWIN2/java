package www.bit.collection;

import java.util.Objects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Stream;


    class Person{
        private String name;
        private  Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, age);
        }
    }
    public class Test {
        public static void main(String[] args) throws Exception {
////        List<Integer> list =new ArrayList<>();
////        list.add(1);
////        list.add(2);
////        list.add(3);
////        System.out.println(list);
////        System.out.println(list.contains(2));
////        System.out.println(list.size());
////        System.out.println(list.remove(1));
////        System.out.println(list.contains(2));
////        System.out.println(list.set(1,9));
////        System.out.println(list);
////    }
//        List<Person> personList=new ArrayList<>();
//        personList.add(new Person("zhangsan",18));
//        personList.add(new Person("lisi",22));
//        System.out.println(personList);
//        System.out.println(personList.contains(new Person("zhangsan",18)));
//        Set<String> set =new TreeSet<>();
//        set.add("1hw");
//        set.add("2lk");
//        set.add("3li");
//        set.add("4ok");
//        System.out.println(set);
//        List<String> list=new ArrayList<>();
//        list.add("j");
//        list.add("j1");
//        list.add("j2");
//        list.add("j3");
//        list.add("j4");
//        list.add("j5");
//        ListIterator<String> listIterator=list.listIterator();
//        while(listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }
//        System.out.println("-------------");
//        while(listIterator.hasPrevious()){
//            System.out.print(listIterator.previous()+"\t");
//        }
//      Map<Integer,String> map=new HashMap<>();
//      map.put(1,"张三");
//      map.put(2,"张三");
//      map.put(3,"张三");
//      map.put(4,"张三");
//      map.put(5,"张si");
//      //1.Map->Set
//      Set<Map.Entry<Integer,String>> set=map.entrySet();
//      //2.取得Set接口迭代器
//      Iterator<Map.Entry<Integer,String>> iterator=set.iterator();
//      //3.迭代输出
//        while (iterator.hasNext()){
//            Map.Entry<Integer,String> entry=iterator.next();
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }
//        Stack stack=new Stack();
//        stack.push("123");
//        stack.push("456");
//        stack.push("1");
//        stack.push("12");
//        stack.push("13");
//        //观察栈顶元素
//        System.out.println(stack.peek());
//        //出栈
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        Queue<Integer> queue=new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        //队中没有元素时出队不报错
//        System.out.println(queue.poll());
//        Properties properties=new Properties();
//        properties.setProperty("user","root");
//        properties.setProperty("password","123456");
//        System.out.println(properties.getProperty("user"));
//        System.out.println(properties.getProperty("password"));
//        System.out.println(properties.getProperty("charSet"));
//        System.out.println(properties.getProperty("charSet",UTF_8));
//        File file=new File("C:\\Users\\聪明机智\\Desktop\\DBConfig.properties");
//        Properties properties=new Properties();
////        properties.setProperty("user","root");
////        properties.setProperty("Password","123456");
////        properties.store(new FileOutputStream(file),"data and password");
//          properties.load(new FileInputStream(file));
//        System.out.println(properties.getProperty("user"));
//        System.out.println(properties.getProperty("Password"));
//        List<String > list=new ArrayList<>();
//        //向集合中一次增加多个元素
//        Collections.addAll(list,"a","b","c","d");
//       Collections.reverse(list);
//        for (String i:list
//             ) {
//            System.out.println(i);
//        }
//        List<Integer> list=new ArrayList<>();
//        Collections.addAll(list,1,2,3,3,4,5,6,7);
//        //forEach就是取出list每个元素，然后调用一下println方法
//        //list.forEach(System.out::println);
//        //取得Stream对象
//        Stream<Integer> stream=list.stream();
//        //统计集合中所有偶数的个数，e就是集合的每个元素
//        //System.out.println(stream.filter(e -> e % 2 == 0).count());
//      //  System.out.println(stream.max(Integer::compareTo).get());
//        System.out.println(stream.min(Integer::compareTo).get());

        }
    }


