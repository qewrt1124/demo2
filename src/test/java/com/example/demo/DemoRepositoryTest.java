package com.example.demo;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DemoRepositoryTest {

    @Autowired
    DemoRepository demoRepository;

    @Test
    public void select() {

        System.out.println(demoRepository.findAll());
    }

    @Test
    public void insert() {
        Demo demo = new Demo();

        demo.setSeq(5L); // Long형인데 Long타입을 맞추지 않아서 error
        demoRepository.save(demo);
    }

    @Test // 기본키를 미리 지정 후 데이터 입력 => save()
    public void update() {
        Demo demo = demoRepository.findById(4L).get();

        demo.setUser("DDD");
        demoRepository.save(demo); // save는 어떤 걸 줬는지에 따라서 insert인지 update인지 바뀜
    }

    @Test // 데이터 조회 후 수정 => save()
    public void update2() {
        Demo demo = new Demo();
        demo.setSeq(4L);
        demo.setUser("DDD222");
        demoRepository.save(demo);
    }

    @Test
    public void user찾기() {
        List<Demo> list = demoRepository.findByUser("A");
        System.out.println(list);
    }

    @Test
    public void user대충찾기() {
        List<Demo> list = demoRepository.findByUserContaining("A"); // user에서 A가 함유되어 있는거 찾음
        System.out.println(list);
    }


}
