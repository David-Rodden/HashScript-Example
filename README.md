**HashScript Concept**

The intention of a HashScript is to find a separate data structure for quick and easy location & execution of tasks within a script.
A HashScript's key/value pair is as follows:
- A key comprising a player's state defined with certain binary attributes
    - Eg. Within a certain area, wearing certain armor, has a full inventory, etc.
- A value represented as the HashNode which has the code to execute a certain task.

Naturally, multiple keys (or states) can be mapped to a single value.
As such, the user can define however many states there can be for a specific task to execute.

Through this barebones implementation, the pros & cons are as follows:

_Pros_
- Provides an O(1) method of finding a task and executing it during runtime.
- Lets user know if there is a conditional overlap, as an IllegalStateException would be thrown

_Cons_
- Depending on approach, can have a lot of conditional overhead
    - Eg. Writing out every single permutation for a current player's status