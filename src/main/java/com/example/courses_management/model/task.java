package com.example.courses_management.model;

public class task {
    private String Name;
    private String title;
    private String description;
    private String main_content;
    private int task_id;
    private int group_id;
    public task(String Name, String title, String description, String main_content){
        this.Name=Name;
        this.title=title;
        this.description=description;
        this.main_content=main_content;
    }
    public task(int task_id, String Name, String title, String description, String main_content, int group_id){
        this.task_id=task_id;
        this.group_id=group_id;
        this.Name=Name;
        this.title=title;
        this.description=description;
        this.main_content=main_content;
    }

    public int getGroup_id() {
        return group_id;
    }

    public int gettask_id() {
        return task_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain_content() {
        return main_content;
    }

    public void setMain_content(String main_content) {
        this.main_content = main_content;
    }

    public String tostring() {
        return task_id+" name "+Name+" title "+title;
    }
}
