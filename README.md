# ser316-spring-B-code-a-mon

To create the code-a-mon implementation, I will use the following decorator patterns
- Decorator Pattern: used for evolutions to overwrite and add behavior
- Factory Pattern: used to build new code-a-mon or trainers
- Mediator Pattern: used because the simulation will be tick based
- Strategy Pattern: used to check damage of a code-a-mon

Code-a-mons can heal in the night

Trainers win code-a-mons as rewards

A new world must start with a number of trainers, at least 2, each of them starts
with at least one code-a-mon. 

Code-a-mons will compete 1v1 with another trainers code-a-mons.

The simulation should run on cycles. A cycle is considered to be of 2 parts - 1 day
time and 1 night time.

Each cycle should have it’s own weather event (these are some examples to give you
ideas, use your creativity!):
– Day 1 - Sunny
– Night 1 - Clear
– Day 2 - Rainy

Weather events should benefit certain types of code-a-mon’s stats while being a disadvantage to others (these are some examples to give you ideas, use your creativity!):
– Sunny: Fire type gains 25% increase in stats and decreases water type by 25%.
– Clear: Neutral.
– Rainy: Water type gains 25% increase in stats and decreases fire type by 25%.

• Code-a-mons should have at minimum:
– Stats: Attack, Defense, Health (Others like speed and so forth can be added if
you would like to implement).
– They should have 1-4 different attacks
– Each attack has a specific type which gains bonus damage if it matches the
type of the user.
– Attacks should have a chance to critical strike (Double damage).
– Attacks should have a chance to miss.
– Attacks should deal a minimum of 1 damage unless they use an attack that
deals 0 base damage.

• Code-a-mons should be of different types and gain advantages or disadvantages based
on their opponent’s type (these are some examples to give you ideas, use your creativity!)