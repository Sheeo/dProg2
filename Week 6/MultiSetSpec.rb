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

  describe "#new" do
    it "initializes an empty multiset" do
      multiset.size.should equal(0)
    end

    context "with parameters" do
      {
        [5,1,2,5] => "{1=1, 2=1, 5=2}",
        [5,2,1] => "{1=1, 2=1, 5=1}",
        [5,5,4,4,1,1,1,1,2] => "{1=4, 2=1, 4=2, 5=2}"
      }.each do |array, toStringValue|
        describe " - #{array.size} elements" do
          let(:multiset) {MultiSet.new(array)}

          it "initializes a non-empty multiset from a collection" do
            multiset.size.should == array.size 
          end

          it "has no duplicates" do
            multiset.toString.should == toStringValue 
          end

        end
      end
    end
  end

  describe "#add" do
    it "adds an item to a multiset" do
      multiset.add(2)
      multiset.size.should equal(1)
    end
  end
end