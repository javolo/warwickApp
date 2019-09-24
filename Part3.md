# Part 3

# Scenario
You just joined a company with one developer who manages his code using GIT. There is also an AWS instance where the developer run tests and nothing else in terms of infrastructure. The company is growing fast and more developers will be joining the team soon and the CEO wants to ship some MVP ASAP. 

# Question
Where would you begin? Please explain how you’d define what needs to be done and why, explaining the pros and cons of your approach. Assume the answer is for a technical person also familiar with software development cycle. 

# Response

I would configure first a database instance using RDS to store any metadata we want, like for example, user information, processing time or maybe the output of it.

After that, I would configure an EC2 instance that will act as a load balancer, so the flux of users is redirected between the different instances we will have.
Also, the purpose of the load balancer is to have an alternative in case of the main instance is down, it´s busy or has any problem.

The configuration of each of the instances would be made with a recipe, where I´ll create all folder structure, I´ll install Tomcat, Java and everything needed in order
to work.
