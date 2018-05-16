use strict;
use warnings;
 
#Reads article and returns the count of words in descending order. Assumes that equivalent words
#with additions of grammatical symbols are different. 
my %count;

#read the file and splits the line to words. Then it stores the frequency of the words appearance
#in a hash, with the word as the key
my $article_file = 'article.txt';
open my $fh, '<', $article_file or die "Could not open file: $article_file";
while (my $line = <$fh>) {
    chomp $line; #removes trailing string
    foreach my $word (split /\s+/, $line) {
        $count{$word}++;
    }
}
 
#sort in descending order based on the value of the hash
foreach my $word (sort {$count{$b} <=> $count{$a} } keys %count) {
    printf "%-15s %s\n", $count{$word}, $word;
}

close $fh or die "Couldn't close file : $article_file";