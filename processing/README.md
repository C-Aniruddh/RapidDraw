# Dataset | Preprocessing and training
-------

You can easily prepocess and train the [quickdraw dataset](https://quickdraw.withgoogle.com/data) to make it work for this application. Since I won't be uploading the dataset myself, you will have to process the dataset on your own for further usage.

## Downloading the data :
 
 Google has open sourced the preprocessed quickdraw dataset and it is openly available in 4 major types. We will be using the numpy bitmaps to generate images which can be trained on our image classifier. 
 
### Numpy bitmaps (.npy)

All the simplified drawings have been rendered into a 28x28 grayscale bitmap in numpy .npy format. The files can be loaded with np.load(). These images were generated from the simplified data, but are aligned to the center of the drawing's bounding box rather than the top-left corner.

Download the dataset from : [Numpy image bitmaps](https://console.cloud.google.com/storage/browser/quickdraw_dataset/full/numpy_bitmap?pli=1)

NOTE: Only download the categories you need. Total size of all the npy files collectively is more than 35gb.

## Processing the data

Here, We will convert our data from the numpy bitmaps form to natural jpegs which can be trained on our image classifier. I've written a simple script to do the job for all the .npy files present in a given folder.

* Create a new folder named 'raw' and move all your .npy files in it.
* [OPTIONAL] : Edit the ```process_all.py``` to change the number of required images : (Change the number_images variable to your desirable amount)
*  Run the processing script : 

```
python3 process_all.py
```

After the script has finished, you will find a new directly, ```'out'``` with all the images in it.

## Training

Now that we have our data in place, clone the tensorflow repository here so that we can use the retrain script : 

```
git clone https://github.com/tensorflow/tensorflow.git
```

For training, we will be using the MobileNets image classifier. You can choose any variant of the classifier according to your needs and change the ```architecture``` parameter while training. 

To start traning, just enter : 

```
python3 tensorflow/tensorflow/examples/image_retraining/retrain.py \
	--image_dir=./out \
    --output_graph=retrained_graph.pb \
    --output_labels=retrained_labels.txt \
    --eval_step_interval=100 \
    --how_many_training_steps=20000 \
    --architecture mobilenet_1.0_224

```
 
 When this finishes, we will have two files : 
 
 * ```retrained_graph.pb``` : The newly generated protobuf graph of our neural network.
 * ```retrained_labels.txt``` : The newly generated labels file.

OPTIONAL : If you have OCD issues like me and can't stand the way each element is listed in the labels text file, then follow this :

I've included a simple python file which rewrites all the elements in our file to give out less OCD strikes.

To run it, simply enter : 

```
python3 label_titles.py retrained_labels.txt
```

In the end, you will get a new file named : label_titles.txt. Be sure to delete the old labels file and rename this to 'retrained_labels.txt'.
