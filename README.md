# PlayFoot CLI engine

Football game engine simulator based on Online Soccer Manager. All of the engine groundwork was done by @zediogoviana and the original repo is [here](https://github.com/zediogoviana/soccer-simulation-engine). 

This is a CLI add-on to the match engine. You don't need to type in literal arguments to kick off a match with the CLI. Just choose a home team and enter the referee's strictness.

## Compiling

Compile all the java classes before your first run:

```
> cd src 
> javac *.java

```

## Running via the CLI app

Just run PlayFoot at the command line

```
> java PlayFoot
```

The app will ask you to choose a home team and set the referee's personality, then it will kick off the main events of the game and print the final result and total of red cards for each team, as well saving those events to a match_results.csv file if you want to test the influence of match variables in your own time.

## Testing

I'm testing match variables to choose the best/most realistic way to extend new features. If you want to bulk test variables yourself, there are separate apps to play out the influence of average age and home team support in the `enginetest` folder.
