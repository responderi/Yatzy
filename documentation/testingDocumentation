## Testing documentation

This documentation explains, why every method and event wasn't/couldn't be tested as JUnit testing. There was a couple problematic test subjects, which either were too huge and would have taken too much time or simply could be tested well enough by just hands.

Methods consisting GUIs (Game class' endGame() for example) were tested by numerous repeats of game playthroughs. Only thing in these to test was that they will appear as they should and appear at correct time.

There was a bug involving scoring pair or two pairs including dice with value of one. However, after numerous repeats, problem was discovered and the major bug was fixed. Indexes during scoring couldnt be changed correctly because indexes were intialized as zeroes, and die value one was at count array's index zero. This was fixed by moving every cell in array one forward (adding its size by one).
Other bugs has not occurred by the time this is written.
