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

  describe "new()" do
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
      multiset.hashCode.should equal(5)
    end
  end

  describe "toString()" do
    {
      [5,1,2,5] => "{1=1, 2=1, 5=2}",
      [5,2,1] => "{1=1, 2=1, 5=1}",
      [5,5,4,4,1,1,1,1,2] => "{1=4, 2=1, 4=2, 5=2}"
    }.each do |inputCollection, toStringValue|

      context " with #{inputCollection}" do
        let(:multiset) {MultiSet.new(inputCollection)}

        it "prints #{toStringValue}" do
          multiset.toString.should == toStringValue
        end
      end
    end
  end

end