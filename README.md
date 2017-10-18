# RapidDraw

RapidDraw is a simple Artificial Intelligence experiment to check if a neural network running on Android can recognize what you are doodling. To make it more fun, there is an entire game wrapped around the neural network. 

On each attempt, you'll be given 1 change to draw 8 different objects. The objects will be chosen randomly from over 100 objects. 


Get it here : https://play.google.com/store/apps/details?id=io.aniruddh.rapiddraw

## Building

Building this is pretty easy. Simply import the files in Android Studio and you are good to go. 

Though there are somethings you have to do yourself : 

* Train the dataset : The retrained_graph.pb and retrained_labels.txt have not been provided in this source. So you'll have to train the neural network yourself to get these files out. Refer to [processing](https://github.com/C-Aniruddh/RapidDraw/tree/in-dev/processing) for details.


## Contributing

* Fork it
* Make necessary changes
* Make a pull request
* I'll merge it if it serves the purpose ;)


## License

This is under the MIT License : 

```
Copyright 2017 Aniruddh Chandratre

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
