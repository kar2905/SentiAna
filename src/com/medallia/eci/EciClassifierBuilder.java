package com.medallia.eci;

import challenge.lib.Classifier;
import challenge.lib.ClassifierBuilder;
import challenge.lib.Sentiment;
import challenge.lib.TaggedReview;
import challenge.run.Main;

/**
 * This class will be loaded by the execution framework via reflection. You must not change the name or the package of
 * this class. This class must implement the {@link ClassifierBuilder} interface.
 * <p>
 * This class must have a no-argument constructor. If you do not put any constructor, Java will create a no-arg
 * constructor for you.
 * <p>
 * With the provided execution framework, the {@link #training(Iterable)} method will be called several times with
 * different subset of the sample set. You should not keep information on static variable about previous sets.
 * This is pointless because during the competition this method will be called just once.
 * <p>
 * The code here must not access the filesystem or the network. It will be run with restricted security permission,
 * similar to a Java Applet in a browser. Your code will be run with -Xmx200M as VM argument. The test set will be supplied
 * as a file similar to reviews-sample.csv but larger than your heap. i.e. 200Mb+
 * <p>
 * To generate a jar for submission, a script has been provided for linux environment. It assumes that ant is available.
 * Please place all libraries in the lib directory and all your source code inside src/com.medallia.eci/ and its
 * subdirectories.  
 * run the following command in the directly in the project directory (where build.xml is found):
 * <code>
 * ant
 * <code>
 * Your jar file will be in the dist/ directory
 * <p>
 * To test run, you can either build the jar and run java -cp dist/com.medallia.challenge.jar com.medallia.eci.EciClassifierBuilder,
 * or just use an IDE and run this file.
 */
public class EciClassifierBuilder implements ClassifierBuilder {

	/**
	 * Startup method for the classifier. This method receives the sample tagged reviews. The code must learn from
	 * these examples, and build a classifier
	 *
	 * @param data Sample tagged reviews
	 * @return  A classifier built on the sample data
	 */
	@Override
	public Classifier training(Iterable<TaggedReview> data) {
		final SimpleTokenizer t = new SimpleTokenizer();

		for (TaggedReview taggedReview : data) {
			//System.out.println(taggedReview.toString());
			// Do the training
			// Learn from the sample data
		}

		// Build the classifier
		return new Classifier() {
			/** @see Classifier#classify(String) */
			/* (non-Javadoc)
			 * @see challenge.lib.Classifier#classify(java.lang.String)
			 */
			@Override
			public Sentiment classify(String review) {
				String s[] = t.tokenize(review);
				for(String x: s){
					System.out.print(x+"-");
				}
				System.out.println();
				// Put your classifier here

				// Replace this dummy return value with your prediction
				return Sentiment.POSITIVE;
			}
		};
	}

	/**
	 * This main method is here for your convenience to ease debugging this class from an IDE.
	 *
	 * DO NOT PUT ANY CODE HERE!!! THIS METHOD IS NOT USED DURING THE COMPETITION !!!!
	 */
	public static void main(String[] args) throws Exception {
		Main.main(args);
	}

}
