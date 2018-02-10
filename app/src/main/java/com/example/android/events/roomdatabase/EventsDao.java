package com.example.android.events.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.android.events.model.Events;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by amirahoxendine on 2/7/18.
 */
@Dao
public interface EventsDao {

        @Query("SELECT * FROM events")
        List<EventsRoomEntity> getAll();

        @Insert(onConflict = REPLACE)
        void insertEvent(EventsRoomEntity event);

        @Insert(onConflict = REPLACE)
        void insertAllEvents(List<EventsRoomEntity> events);

        @Query("SELECT * FROM events where id LIKE  :id")
        EventsRoomEntity findEventByID(String id);

        @Delete
        void deleteEvent(EventsRoomEntity event);

        @Query("SELECT COUNT(*) from events")
        int countEvents();

}
