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
    it "initializes an empty multiset" do
      multiset.size.should equal(0)
    end

    it "initializes a non-empty multiset" do
      multiset = MultiSet.new([5,2,3])
      multiset.size.should equal(3)
    end
  end

  describe "add()" do
    it "adds an item to the multiset" do
      multiset.add(2)
      multiset.size.should equal(1)
    end
  end

  describe "remove()" do
    it "removes an item from the multiset" do
      multiset.add(2)
      multiset.remove(2)
      multiset.size.should equal(0)
    end
  end

  describe "addAll()" do
    it "adds all elements from a collection" do
      multiset.addAll([5,2,3,2])
      multiset.size.should equal(4)
    end
  end

  describe "hashCode()" do
    it "returns a hashcode of the multiset" do
      multiset.addAll([1,1,1,1])
      multiset.hashCode.should_not equal(nil)
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

    it "is able to remove elements from the MultiSet" do
      pending "MultiIterator is weird"
      iterator = multiset.iterator
      iterator.next
      iterator.remove
      multiset.size.should == 6
    end
  end
end
