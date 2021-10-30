package com.example.cardio_diagnostics.managers;

import android.util.ArrayMap;

import com.example.cardio_diagnostics.beans.TaskItem;
import com.example.cardio_diagnostics.utils.LogUtils;

import java.util.List;

public class FavoritesManager {

    private static ArrayMap<Integer, String> favoritesTasks;
    public static void setFavoritesTasks(List<TaskItem> taskItems) {
        favoritesTasks = new ArrayMap<>();
        for (TaskItem taskItem : taskItems) {
            if(!FavoritesManager.findTaskInFavorites(taskItem.getId())){
                favoritesTasks.put(taskItem.getId(), taskItem.getId()+"Title");
            }
        }
        LogUtils.print("tasks: "+favoritesTasks);
    }

    public static void removeFromFavorites(int taskID) {
        if(FavoritesManager.findTaskInFavorites(taskID)){
            favoritesTasks.remove(taskID);
        }
        LogUtils.print("tasks: "+favoritesTasks);
    }

    public static void addFavorites(int taskID, String taskName) {
        if(favoritesTasks == null){
            favoritesTasks = new ArrayMap<>();
        }
        favoritesTasks.put(taskID, taskID+"Title");
        LogUtils.print("tasks: "+favoritesTasks);
    }

    public static boolean findTaskInFavorites(int EntityId) {
        if(favoritesTasks != null && favoritesTasks.containsKey(EntityId)){
            return  true;
        }
       return false;
    }

    public static int SumOfTaskInFavorites() {
        if(favoritesTasks != null){
            return  favoritesTasks.size();
        }
        return 0;
    }

    public static void clearFavoritesTasks() {
        if(favoritesTasks != null){
            favoritesTasks.clear();
        }
    }
}