from bisect import bisect_left, bisect_right

#This function will take in an article, read it and store the count for each unique word.
#Assumes that equivalent words with additions of grammatical symbols are different. 
def unique_words(lower_bound, upper_bound, absolute_path):
    #make a dictionary with the key=value pair being word to frequency. 
    unique_words = {}
    #open file from path and iterate through each line. Split each line into words
    #and store the frequency of the words
    with open (absolute_path) as f:
        lines = f.readlines()
        for line in lines:
            words = line.split()
            for word in words:
                unique_words[word] = unique_words.get(word, 0) + 1

    #store a list of keys by their frequency
    sorted_key_list = sorted(unique_words, key=unique_words.get)
    #store a list of values in ascending order
    sorted_values = []
    for j in sorted_key_list:
        sorted_values.append(unique_words[j])
    #obtain index of lower and upper index based on range
    lower_index = bisect_left(sorted_values, lower_bound)
    upper_index = bisect_right(sorted_values, upper_bound)
    #iterate down from upper bound to lower bound 
    for i in range(upper_index-1, lower_index-1, -1):
        print('{: <20} {: <20}'.format(str(unique_words[sorted_key_list[i]]), str(sorted_key_list[i])))

unique_words(1, 3, "/Users/Christine/Documents/article.txt")