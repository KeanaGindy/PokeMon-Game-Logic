# ser316-spring-B-code-a-mon

> Screenshots seen in TestScreenshots.pdf

To create the code-a-mon implementation, I will use the following decorator patterns
- Decorator Pattern: used for different types of Code-A-Mon
- Factory Pattern: used to build new code-a-mon, trainers, attacks, battles, and worlds
- Mediator Pattern: used to create the cycle-based stimulation. This is directly seen in WorldMediator.java

# Requirements fulfilled
- A new world must start with a number of trainers, at least 2, each of them starts with at least one code-a-mon. 
- The trainer can acquire more code-a-mons (max of 6) throughout their adventure. Acquired in the stimulation on creation of a trainer or after winning a battle.
- Each cycle should have it’s own weather event. The day will randomly be sunny, rainy, or clear. The night will always be clear. 
- Code-a-mons will compete 1v1 with another trainers code-a-mons.
- The simulation should run on cycles. A cycle is considered to be of 2 parts - 1 daytime and 1 night time. 1.5 cycles in shown in the screencast.
- Weather events should benefit certain types of code-a-mon’s stats while being a disadvantage to others. If the weather matches a Code-A-Mon's type, its health is increased by 20 at the beginning of the battle. Sunny = fire, Rainy = water, Clear = grass.
- Code-a-mons should have at minimum:
 > Stats: Attack, Defense, Health (Others like speed and so forth can be added if
you would like to implement).
 > They should have 1-4 different attacks
 > Each attack has a specific type which gains bonus damage if it matches the
type of the user.
 > Attacks should have a chance to critical strike (Double damage).
 > Attacks should have a chance to miss.
 > Attacks should deal a minimum of 1 damage unless they use an attack that deals 0 base damage.
- Code-a-mons should be of different types and gain advantages or disadvantages based on their opponent’s type. If the attack of a code-a-mon matches the type of the opponent, its damage is higher.
- In the night, a trainer's first Code-A-Mon will evolve and will recieve a random bonus attack.
- Only one battle can take place at a time. A battle is always between two trainers and each using one code-a-mon.

# Screen Cast
https://drive.google.com/file/d/1-sKKTS4AR73Xp-bQcXqEi9Rw81x9bW6K/view?usp=sharing
