# Yatzy
Yatzy is a dice game, in which you try to score as good score for each given category as you can. Winner is the one with highest score.

## Documentation
* [Topic's description and structure](documentation/aiheenKuvausJaRakenne.md)
* [Time usage](documentation/tuntikirjanpito.md)
* [Testing documentation](documentation/testingDocumentation.md)

## Checkstyle and Pit-reports
* [Checkstyle-report](https://htmlpreview.github.io/?https://github.com/responderi/Yatzy/blob/master/documentation/checkstyle-reports/checkstyle.html)
* [Pit-report](https://htmlpreview.github.io/?https://github.com/responderi/Yatzy/blob/master/documentation/pit-reports/201705032046/index.html)

## Instructions:

Game is very simple to use. Start up the jar file in directory and follow the rules given in game. Rules and how to play will popup when game is started, but here they are in short:
* You try to score each category with 2 rerolls each turn. During each reroll you are allowed to throw every dice.
* You will be forced to score after 2 rerolls (not including round starting reroll), unless you have pressed 'Score' by yourself earlier.
* Score fitting category when the screen is presented to you.
* Next player's turn will start by pressing 'End turn' after scoring event.
* This will keep going for 13 turns per player and after that there will be an end screen with results. You can exit the game by pressing 'Exit' button.
