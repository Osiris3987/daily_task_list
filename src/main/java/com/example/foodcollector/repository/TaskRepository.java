package com.example.foodcollector.repository;

import com.example.foodcollector.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = """
            SELECT * FROM tasks t
            JOIN users_tasks ut ON ut.task_id = t.id
            WHERE ut.user_id = :userId
            """, nativeQuery = true)
    List<Task> findAllByUserId(@Param("userId") Long userId);

    @Modifying
    @Query(value = """
            INSERT INTO users_tasks (user_id, task_id)
            VALUES (:userId, :taskId)
            """, nativeQuery = true)
    void assignTask(@Param("userId") Long userId, @Param("taskId") Long taskId);

    @Query(value = """
            SELECT * FROM tasks t
            WHERE t.expiration_date is not null
            AND t.expiration_date between :start and :end
            """, nativeQuery = true)
    List<Task> findAllSoonTasks(@Param("start") Timestamp start,
                                @Param("end") Timestamp end);
}
