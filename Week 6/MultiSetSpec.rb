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
  let(:multiset) { MultiSet.new }

  describe "MultiSet()" do
    it "should initialize an empty multiset" do
      multiset.size.should equal(0)
    end

    it "should initialize a non-empty multiset" do
      multiset = MultiSet.new([5,2,3])
      multiset.size.should equal(3)
    end
  end

  describe "add()" do
    it "should add an item to the multiset" do
      multiset.add(2)
      multiset.size.should equal(1)
    end
  end

  describe "remove()" do
    it "should remove an item from the multiset" do
      multiset.add(2)
      multiset.remove(2)
      multiset.size.should equal(0)
    end
  end

  describe "addAll()" do
    it "should add all elements from a collection" do
      multiset.addAll([5,2,3,2])
      multiset.size.should equal(4)
    end
  end

  describe "hashCode()" do
    it "should return a hashcode of the multiset" do
      multiset.addAll([1,1,1,1])
      multiset.hashCode.should_not equal(nil)
    end

    it "should return the same hashcode for identical objects" do
      multiset.addAll([1,2,3,4])
      multiset.hashCode.should == MultiSet.new([1,2,3,4]).hashCode
    end
    
    it "should not return the same hashcode for different objects" do
      multiset.addAll([1,2,3,4])
      multiset.hashCode.should_not == MultiSet.new([1,1,2]).hashCode
    end
  end

  describe "toString()" do
    {
      [5,1,2,5] => "{1=1, 2=1, 5=2}",
      [5,2,1] => "{1=1, 2=1, 5=1}",
      [5,5,4,4,1,1,1,1,2] => "{1=4, 2=1, 4=2, 5=2}",
      ["foo", "bar", "goat"] => "{goat=1, foo=1, bar=1}",
      ["foo", "foo", "goat"] => "{goat=1, foo=2}"
    }.each do |inputCollection, toStringValue|

      context " with #{inputCollection.join(" ")}" do
        let(:multiset) {MultiSet.new(inputCollection)}

        it "prints #{toStringValue}" do
          multiset.toString.should == toStringValue
        end
      end
    end
  end

  describe "iterator()" do
    let(:multiset) {MultiSet.new([5,4,3,2,2,1,0])}

    it "returns an iterator that iterates through a MultiSet" do
      iterator = multiset.iterator
      iterator.hasNext.should == true 
      iterator.next.should == 0 # apparently the array is reversed
      iterator.next.should == 1
    end
    describe "MultiIterator" do
      describe "remove()" do
        it "should remove elements from the MultiSet" do
          pending "MultiIterator is weird"
          iterator = multiset.iterator
          iterator.next
          iterator.remove
          multiset.size.should == 6
        end
      end
    end
  end
end
