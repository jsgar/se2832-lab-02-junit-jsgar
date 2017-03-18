# Write-Up for Jenna Sgarlata (sgarlatajj@msoe.edu)
## What sort of strategy did you use to come up with your test cases? 
My main strategy when coming up with test cases was going through the video Dr. Taylor made for Data Structures on the circular queue and
find places where someone could screw up. Once I had a good idea of what could go wrong, I made a test case for each of the scenarios and
linked it to the method. Then, I added in a test case to verify that the method was functioning properly. With a few exceptions, I had two
tests per method.

## How did you know when you were finished?
I knew I was finished when I left the code alone for a few days and went back to it and could not find anything else. (Though I did check 
back on this code at midnight on a Firday...) It's like proofreading a paper. When you spend hours of staring at it, you tend to overlook 
errors that were in plain sight. I have used this strategy when working with papers, projects, and other written submissions, and it has 
worked well for me. I felt that implementing this strategy in coding could be a better alternative to comparing myself to others.

## Errors Found
| Line | Fault Description | Fix Description |
|:----:|:----------------- |:--------------- |
| 50   | The maximum queue size could have been set to zero | Change the conditional to throw exception when zero was passed in |
| 53   | The counstructor never set the capacity to the size passed in | Add in a line that did so |
| 81   | The method was returning the last element | Change the returned element to the first element |
| 90   | Assigning the last element placed the element at the wrong index | Move tail up a line to increment prior to assignment |
| 102  | The method was returning the last element | Change the returned element to the first element |
| 120  | The method was returning the last element | Change the returned element to the first element |
| 147  | The index of the last element was incorrect and incompatible with the rest of the implementation | Change to -1 |
| 148  | The index of the first element was incorrect and incompatible with the rest of the implementation | Change to 0 |
| 210  | The offset was calculated using the tail, not the head | Replace "tail" with "head" in that line |


