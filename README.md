 ADSO:

Astronaut Daily Schedule Organizer


---> Overview

  The Astronaut Daily Schedule Organizer is a console-based application designed to assist astronauts in managing their day-to-day tasks with precision and efficiency. Whether in space or on Earth, time management is critical, and this tool ensures that daily schedules run smoothly without conflicts. This application allows users to organize their tasks by creating and managing a list of activities throughout the day. It supports features like task prioritization, conflict detection, and notifications. By providing a clear overview of the schedule and alerting the user when tasks overlap or conflict, the app ensures that tasks can be managed efficiently. The organizer operates using a menu-driven interface, making it easy for users to interact with the system. Users can add new tasks by specifying the task description, start time, end time, and priority level (HIGH, MEDIUM, or LOW). The application automatically checks for scheduling conflicts and notifies the user if any overlap exists, ensuring that no two tasks clash with each other. Additionally, users can edit tasks, mark them as completed, or remove them if no longer needed. For further organization, the app allows users to view tasks based on priority, making it easier to focus on high-priority tasks first. At its core, the *Astronaut Daily Schedule Organizer* is built around object-oriented principles, including the *Observer Design Pattern*, which is used to notify the user of important events like task conflicts. This enhances the interactivity of the system, ensuring that users are always informed of issues in real-time.
    In summary, this application helps manage time efficiently, avoid scheduling conflicts, and ensure that astronauts—or any users with packed schedules—remain on top of their daily tasks in an organized and structured manner.
     
---> Features
- Task Management: Add, edit, remove, and view tasks.
- Task Prioritization: Assign priorities to tasks (HIGH, MEDIUM, LOW).
- Conflict Notification: Notifies users of scheduling conflicts when adding tasks.
- Task Completion Tracking: Mark tasks as completed.
- Task Filtering: View tasks based on their priority levels.
- Observer Pattern: Uses the observer pattern to notify users of task conflicts.

---> How It Works
The application operates through a menu-driven interface, allowing the user to manage their tasks. Users can input task details such as the description, start time, end time, and priority level. The application will prevent overlapping tasks by notifying the user of any conflicts.

---> Classes and Structure

1. Main.java
This is the entry point of the application. It manages the user interface, provides a menu system, and interacts with the ScheduleManager to manage tasks.

2. Task.java
Defines the task structure, including task properties:
- Description
- Start Time
- End Time
- Priority (HIGH, MEDIUM, LOW)
- Completion Status

3. TaskFactory.java
Handles task creation and ensures that task times are in the correct HH:mm format.

4. TaskObserver.java and TaskConflictNotifier.java
Implements the *Observer Pattern* to notify users when there are scheduling conflicts between tasks.

 5. ScheduleManager.java
This is a singleton class responsible for managing all tasks. It provides functionality for:
- Adding tasks
- Removing tasks
- Editing tasks
- Marking tasks as completed
- Viewing tasks (either all or by priority)

 6. LoggerUtility.java
Logs system events such as task additions, removals, and conflicts, providing insight into what actions the application is taking.

 Installation and Usage

 Steps to Run
1. Clone the repository or download the project:
   bash
   git clone https://github.com/rsLingaraj/ADSO.git
   cd astronaut-scheduler
   
   
2. Compile and run the Java project:
   bash
   javac -d bin src/com/astronaut/*.java
   java -cp bin com.astronaut.Main
   

---> Usage Instructions
Once the program is running, you'll be presented with a menu:

Menu:
1. Add a new task
2. Remove a task
3. View all tasks
4. Edit an existing task
5. Mark a task as completed
6. View tasks by priority
7. Exit
Enter your choice:

Follow the prompts to add, view, edit, or remove tasks. The program will notify you if any conflicts are detected.

---> Example
Here's an example of adding a new task:
1. Choose option 1 to add a new task.
2. Enter the task description, start time (in HH:mm format), end time, and priority.
3. If there is no conflict, the task will be added successfully. Otherwise, you will be notified of a conflict.

---> Observer Pattern Implementation
The program uses the Observer Pattern to notify the user when task conflicts occur. The TaskConflictNotifier class listens for conflicts and prints a message whenever a conflict is detected.

---> Logging
The LoggerUtility class logs important events, such as when a task is added, removed, or edited, or when a conflict is detected. Logs are printed to the console with a timestamp for each event.

---> Contributions
Feel free to open a pull request or file an issue if you'd like to contribute to the project.


