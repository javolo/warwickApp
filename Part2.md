# Part 2

# Scenario
The app you implemented in Part 1 is almost ready to go into production, where we expect to receive data in all sizes and from hundreds of customers at the same time.

# Question
How do you make that app scalable and ready for the scenarios above? 

# Response

To make it scalable I would probably implement as first option, a load balancer. In that way, I would redirect the customers into different servers and not overload only
one.

As second option, I would implement multi-threading and I would create a scheduler to manage it. However, this solution can be as complex as you want to make it and it´s 
going to depend on the design of the application, quantity or quickness. Depending on that selection, the thread scheduler can change completely.

For example, small and medium files can be done by one thread. However, big files can be split and use multiple threads for the same file. Splitting the files carries more
processing work as you have to make the different parts, assign the thread, take the output and merge all the parts before sending it back to the user.
