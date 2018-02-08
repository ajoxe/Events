package com.example.android.events.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by amirahoxendine on 2/7/18.
 */
@Dao
public interface EventsDao {

        @Query("SELECT * FROM EventsRoomEntity")
        List<EventsWithImagesEntity> getAll();

}
