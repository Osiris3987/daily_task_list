package com.example.foodcollector.service.Impl;

import com.example.foodcollector.domain.MailType;
import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.domain.user.User;
import com.example.foodcollector.service.MailService;
import com.example.foodcollector.service.Reminder;
import com.example.foodcollector.service.TaskService;
import com.example.foodcollector.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class ReminderImpl implements Reminder {
    private final TaskService taskService;
    private final UserService userService;
    private final MailService mailService;
    private final Duration duration = Duration.ofHours(1);

    @Scheduled(cron = "0 0 * * * *")
    @Override
    public void remindForTask(){
        List<Task> tasks = taskService.getAllSoonTasks(duration);
        tasks.forEach(task -> {
            User user = userService.getTaskAuthor(task.getId());
            Properties properties = new Properties();
            properties.setProperty("task.title", task.getTitle());
            properties.setProperty("task.description", task.getDescription());
            mailService.sendMail(user, MailType.REMINDER, properties);
        });
    }
}
