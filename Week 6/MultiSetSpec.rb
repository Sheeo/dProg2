# Ruby-RSpec klasse brugt til at beskrive MultiSet-java klassen med
#
# For at køre:
#   make spec
#
# Kræver:
#   jruby (http://jruby.org)
#   rspec (gem install rspec)
#

include Java
require 'rubygems'
require 'rspec'
import 'MultiSet'
include_class Java::MultiSet

describe MultiSet do
 context "when created empty" do
   before(:each) do
     @multiset = MultiSet.new
   end
   
   it "should be empty" do
     @multiset.size.should == 0
   end

   it "should respond to #toString" do
     @multiset.toString.should == "{}"
   end

   it "should respond to #add" do
     @multiset.add(5)
     @multiset.size.should == 1
   end
    
   it "should fail to #remove" do
     @multiset.remove(5).should == false
   end

   it "should be able to add and remove" do
     @multiset.add(2).should == true
     @multiset.add(3).should == true
     @multiset.add(2).should == true
     @multiset.remove(2).should == true
   end
 end

 context "when created with a collection" do
   before(:each) do
     @multiset = MultiSet.new([5, 4, 2, 1])
   end

   it "should not be empty" do
     @multiset.size.should > 0
   end

   it "should respond to #toString with \"{5=1, 4=1, 2=1, 1=1}\"" do
     @multiset.toString.should == "{1=1, 2=1, 4=1, 5=1}"
   end

 end
end